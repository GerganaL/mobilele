package bg.softuni.lection2.mobilele.service;

import bg.softuni.lection2.mobilele.model.view.BrandViewModel;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BrandService {
   List<BrandViewModel> getAllBrands();
}
