package goldDigger.repositories;

import goldDigger.models.discoverer.Discoverer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class DiscovererRepository implements Repository<Discoverer> {
    private List<Discoverer> discoverers;

    public DiscovererRepository() {
        this.discoverers = new ArrayList<>();
    }

    @Override
    public Collection<Discoverer> getCollection() {
        return Collections.unmodifiableCollection(this.discoverers);
    }

    @Override
    public void add(Discoverer entity) {
        this.discoverers.add(entity);
    }

    @Override
    public boolean remove(Discoverer entity) {
        return this.discoverers.remove(entity);
    }

    @Override
    public Discoverer byName(String name) {
        return this.discoverers.stream()
                .filter(n -> n.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
