package bg.softuni.lection2.mobilele;

import bg.softuni.lection2.mobilele.model.entites.*;
import bg.softuni.lection2.mobilele.model.entites.enums.EngineEnum;
import bg.softuni.lection2.mobilele.model.entites.enums.ModelCategoryEnum;
import bg.softuni.lection2.mobilele.model.entites.enums.TransmitionEnum;
import bg.softuni.lection2.mobilele.repository.BrandRepository;
import bg.softuni.lection2.mobilele.repository.ModelRepository;
import bg.softuni.lection2.mobilele.repository.OfferRepository;
import bg.softuni.lection2.mobilele.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Component
public class DBInit implements CommandLineRunner {

    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;
    private final OfferRepository offerRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DBInit(ModelRepository modelRepository, BrandRepository brandRepository,
                  OfferRepository offerRepository, UserRepository userRepository,
                  PasswordEncoder passwordEncoder) {
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
        this.offerRepository = offerRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public void run(String... args) throws Exception {
        BrandEntity fordBrand = new BrandEntity();
        fordBrand.setName("Ford");
        setCurrentTimestamps(fordBrand);

        BrandEntity hondaBrand = new BrandEntity();
        hondaBrand.setName("Honda");
        setCurrentTimestamps(hondaBrand);

        brandRepository.saveAll(List.of(fordBrand, hondaBrand));

        ModelEntity fiestaModel = initFiesta(fordBrand);
        initEscort(fordBrand);
      initNC750S(hondaBrand);
      createFiestaOffer(fiestaModel);

      initAdmin();
    }

    private void initAdmin(){
        UserEntity admin = new UserEntity();
        admin
                .setFirstName("Peter")
                .setLastName("Dimitrov")
                .setUsername("admin")
                .setPassword(passwordEncoder.encode("topsecret"));
        setCurrentTimestamps(admin);
        userRepository.save(admin);
    }

    private void createFiestaOffer(ModelEntity model){
        OfferEntity fiestaOffer = new OfferEntity();
        fiestaOffer.setEngine(EngineEnum.GASOLINE)
                .setImageUrl("https://media.autoexpress.co.uk/image/private/s--X-WVjvBW--/f_auto,t_content-image-full-desktop@1/v1562244788/autoexpress/2017/07/dsc_1328-1.jpg")
                .setMileage(40000)
                .setPrice(BigDecimal.valueOf(10000))
                .setYear(2019)
                .setDescription("Karana e ot nemska baba. Zimata v garaj")
                .setTransmission(TransmitionEnum.MANUAL)
                .setModel(model);
        setCurrentTimestamps(fiestaOffer);

        offerRepository.save(fiestaOffer);
    }

    private ModelEntity initFiesta(BrandEntity brand) {
        ModelEntity fiesta = new ModelEntity();

        fiesta
                .setName("Fiesta")
                .setCategory(ModelCategoryEnum.CAR)
                .setImageUrl("https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/2017-ford-fiesta-1557785069.jpg")
                .setStartYear(1976)
                .setBrand(brand);

        setCurrentTimestamps(fiesta);

        return modelRepository.save(fiesta);
    }
    private ModelEntity initEscort(BrandEntity brand) {
        ModelEntity escort = new ModelEntity();

        escort
                .setName("Fiesta")
                .setCategory(ModelCategoryEnum.CAR)
                .setImageUrl("https://upload.wikimedia.org/wikipedia/commons/3/39/Ford_Escort_RS2000_MkI.jpg")
                .setStartYear(1968)
                .setEndYear(2002)
                .setBrand(brand);

        setCurrentTimestamps(escort);

        return modelRepository.save(escort);
    }
    private ModelEntity initNC750S(BrandEntity brand) {
        ModelEntity nc750s = new ModelEntity();

        nc750s
                .setName("NC750S")
                .setCategory(ModelCategoryEnum.MOTORCYCLE)
                .setImageUrl("https://pictures.topspeed.com/IMG/jpg/201404/honda-nc750s-15.jpg")
                .setStartYear(2014)
                .setBrand(brand);

        setCurrentTimestamps(nc750s);

        return modelRepository.save(nc750s);
    }

    private static void setCurrentTimestamps(BaseEntity baseEntity) {
        baseEntity
                .setCreated(Instant.now())
                .setUpdated(Instant.now());
    }
}
