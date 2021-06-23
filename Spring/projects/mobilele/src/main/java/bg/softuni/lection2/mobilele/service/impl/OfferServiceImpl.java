package bg.softuni.lection2.mobilele.service.impl;

import bg.softuni.lection2.mobilele.model.entites.OfferEntity;
import bg.softuni.lection2.mobilele.model.service.OfferServiceModel;
import bg.softuni.lection2.mobilele.model.view.OfferSummaryViewModel;
import bg.softuni.lection2.mobilele.repository.ModelRepository;
import bg.softuni.lection2.mobilele.repository.OfferRepository;
import bg.softuni.lection2.mobilele.repository.UserRepository;
import bg.softuni.lection2.mobilele.security.CurrentUser;
import bg.softuni.lection2.mobilele.service.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {

    private final CurrentUser currentUser;
    private final OfferRepository offerRepository;
    private final UserRepository userRepository;
    private final ModelRepository modelRepository;
    private final ModelMapper modelMapper;

    public OfferServiceImpl(CurrentUser currentUser, OfferRepository offerRepository,
                            UserRepository userRepository, ModelRepository modelRepository,
                            ModelMapper modelMapper) {
        this.currentUser = currentUser;
        this.offerRepository = offerRepository;
        this.userRepository = userRepository;
        this.modelRepository = modelRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<OfferSummaryViewModel> getAllOffers() {
        //TODO implement mapping
        return null;
    }

    @Override
    public long save(OfferServiceModel model) {
    OfferEntity offerEntity = asNewEntity(model);
        OfferEntity newEntity = offerRepository.save(offerEntity);
        return newEntity.getId();
    }

    @Override
    public void delete(long id) {
        offerRepository.deleteById(id);
    }

    private OfferEntity asNewEntity(OfferServiceModel model){
        OfferEntity offerEntity = new OfferEntity();
        modelMapper.map(model,offerEntity);
        offerEntity.setId(null);

        offerEntity.setModel(modelRepository.findById(model.getModelId()).orElseThrow());
        offerEntity.setUser(userRepository.findByUsername(currentUser.getName()).orElseThrow());
        return offerEntity;

    }
}
