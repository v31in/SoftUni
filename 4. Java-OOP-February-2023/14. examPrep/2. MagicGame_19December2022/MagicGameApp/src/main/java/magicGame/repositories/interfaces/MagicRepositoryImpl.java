package magicGame.repositories.interfaces;

import magicGame.common.ExceptionMessages;
import magicGame.models.magics.Magic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MagicRepositoryImpl implements MagicRepository<Magic> {
    private List<Magic> data;

    public MagicRepositoryImpl() {
        this.data = new ArrayList<>();
    }

    @Override
    public Collection<Magic> getData() {
        return Collections.unmodifiableCollection(getData());
    }

    @Override
    public void addMagic(Magic model) {
        if (model == null) {
            throw new NullPointerException(ExceptionMessages.INVALID_MAGIC_REPOSITORY);
        }
        this.data.add(model);
    }

    @Override
    public boolean removeMagic(Magic model) {
        return this.data.remove(model);
    }

    @Override
    public Magic findByName(String name) {
        return this.data.stream()
                .filter(n -> n.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
