package bg.softuni.lection2.mobilele.service.impl;

import bg.softuni.lection2.mobilele.model.entites.BrandEntity;
import bg.softuni.lection2.mobilele.model.entites.ModelEntity;
import bg.softuni.lection2.mobilele.model.view.BrandViewModel;
import bg.softuni.lection2.mobilele.model.view.ModelViewModel;
import bg.softuni.lection2.mobilele.repository.ModelRepository;
import bg.softuni.lection2.mobilele.service.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService {
    private final ModelRepository modelRepository;
    private final ModelMapper modelMapper;

    public BrandServiceImpl(ModelRepository modelRepository, ModelMapper modelMapper) {
        this.modelRepository = modelRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<BrandViewModel> getAllBrands() {
        List<BrandViewModel> result = new ArrayList<>(); // <- final result here
        List<ModelEntity> allModels = modelRepository.findAll();  // <- getting all models


        allModels.forEach(m -> {
            //example: fiesta -> ford
            BrandEntity brandEntity = m.getBrand();

            Optional<BrandViewModel> brandViewModelOpt = findByName(result, brandEntity.getName());
            if(!brandViewModelOpt.isPresent()){
                //not yet in the result, we will create a new model
                BrandViewModel newBrandViewModel = new BrandViewModel();
                this.modelMapper.map(brandEntity,newBrandViewModel);
                result.add(newBrandViewModel);
                brandViewModelOpt = Optional.of(newBrandViewModel);
            }

            ModelViewModel newModelViewModel = new ModelViewModel();
            modelMapper.map(m,newModelViewModel);
            brandViewModelOpt.get().addModel(newModelViewModel);

        });
        return result;
    }

    private static Optional<BrandViewModel> findByName(List<BrandViewModel> allModels, String name){
       return allModels
               .stream()
               .filter(m  -> m.getName().equals(name))
               .findAny();
    }
}
