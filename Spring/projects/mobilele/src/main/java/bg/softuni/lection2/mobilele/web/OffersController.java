package bg.softuni.lection2.mobilele.web;

import bg.softuni.lection2.mobilele.model.entites.enums.EngineEnum;
import bg.softuni.lection2.mobilele.model.entites.enums.TransmitionEnum;
import bg.softuni.lection2.mobilele.model.service.OfferServiceModel;
import bg.softuni.lection2.mobilele.model.service.UserLoginServiceModel;
import bg.softuni.lection2.mobilele.service.BrandService;
import bg.softuni.lection2.mobilele.service.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/offers")
public class OffersController {

    private final OfferService offerService;
    private final BrandService brandService;

    public OffersController(OfferService offerService, BrandService brandService) {
        this.offerService = offerService;
        this.brandService = brandService;
    }
    @ModelAttribute("offerModel")
    public OfferServiceModel offerModel(){
        return new OfferServiceModel();
    }

    @GetMapping("/all")
    public String getAllOffers(Model model){
        //TODO
      //  model.addAttribute("models",offerService.getAllOffers());
        return "offers";
    }
    @GetMapping("/add")
    public String addOffer(Model model){
        model.addAttribute("brands", brandService.getAllBrands());
        model.addAttribute("engines", EngineEnum.values());
        model.addAttribute("transmissions", TransmitionEnum.values());

        return "offer-add";
    }

    @PostMapping("/add")
    public String addOfferConfirm(@Valid @ModelAttribute OfferServiceModel offerModel,
                                  BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("offerModel",offerModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.offerModel",bindingResult);
            return "redirect:/offers/add";
        }

      long newOfferId = offerService.save(offerModel);
        return "redirect:/offers/offer/" + newOfferId;
    }

    @GetMapping("/offer/{id}")
    public String offerDetails(@PathVariable String id, Model model){
        model.addAttribute("id",id);
        return "details";
    }

    @DeleteMapping("/offer/{id}")
    public String delete(@PathVariable Long id, Model model){
       offerService.delete(id);
        return "redirect:/offers/all";
    }
}
