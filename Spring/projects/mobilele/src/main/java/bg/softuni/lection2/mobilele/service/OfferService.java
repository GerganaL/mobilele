package bg.softuni.lection2.mobilele.service;

import bg.softuni.lection2.mobilele.model.service.OfferServiceModel;
import bg.softuni.lection2.mobilele.model.view.OfferSummaryViewModel;

import java.util.List;

public interface OfferService {
    List<OfferSummaryViewModel> getAllOffers();

    long save(OfferServiceModel model);
    void delete(long id);
}
