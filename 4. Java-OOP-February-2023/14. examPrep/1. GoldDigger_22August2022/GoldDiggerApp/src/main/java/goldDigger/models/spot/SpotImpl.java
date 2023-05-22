package goldDigger.models.spot;

import goldDigger.common.ExceptionMessages;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SpotImpl implements Spot{
    private String name;
    private List<String> exhibits;

    public SpotImpl(String name) {
        setName(name);
        this.exhibits = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.SPOT_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setExhibits(List<String> exhibits) {
        this.exhibits = exhibits;
    }

    @Override
    public Collection<String> getExhibits() {
        return this.exhibits;
    }
}
