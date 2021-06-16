package bg.softuni.lection2.mobilele.model.view;

import java.util.List;

public class ModelViewModel {

    private  String name;
    private List<ModelViewModel> models;

    public String getName() {
        return name;
    }

    public ModelViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public List<ModelViewModel> getModels() {
        return models;
    }

    public ModelViewModel setModels(List<ModelViewModel> models) {
        this.models = models;
        return this;
    }

    @Override
    public String toString() {
        return "ModelViewModel{" +
                "name='" + name + '\'' +
                ", models=" + models +
                '}';
    }
}
