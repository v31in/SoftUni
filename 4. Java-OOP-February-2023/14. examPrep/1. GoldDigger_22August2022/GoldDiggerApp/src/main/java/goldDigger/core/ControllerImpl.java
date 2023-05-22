package goldDigger.core;

import goldDigger.common.ConstantMessages;
import goldDigger.common.ExceptionMessages;
import goldDigger.models.discoverer.Anthropologist;
import goldDigger.models.discoverer.Archaeologist;
import goldDigger.models.discoverer.Discoverer;
import goldDigger.models.discoverer.Geologist;
import goldDigger.models.operation.Operation;
import goldDigger.models.operation.OperationImpl;
import goldDigger.models.spot.Spot;
import goldDigger.models.spot.SpotImpl;
import goldDigger.repositories.DiscovererRepository;
import goldDigger.repositories.SpotRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private DiscovererRepository discovererRepository;
    private SpotRepository spotRepository;

    private Operation operation;

    private int inspectionCount;

    public ControllerImpl() {
        this.discovererRepository = new DiscovererRepository();
        this.spotRepository = new SpotRepository();
        this.operation = new OperationImpl();
        this.inspectionCount = 0;
    }

    @Override
    public String addDiscoverer(String kind, String discovererName) {
        Discoverer discoverer = null;

        //check kind
        //create discoverer
        if (kind.equals("Anthropologist")) {
            //create discoverer
            discoverer = new Anthropologist(discovererName);
        } else if (kind.equals("Archaeologist")) {
            //create discoverer
            discoverer = new Archaeologist(discovererName);
        } else if (kind.equals("Geologist")) {
            //create discoverer
            discoverer = new Geologist(discovererName);
        } else {
            //throw if invalid kind
            throw new IllegalArgumentException(ExceptionMessages.DISCOVERER_INVALID_KIND);
        }

        // store in repo
        discovererRepository.add(discoverer);

        //result
        return String.format(ConstantMessages.DISCOVERER_ADDED, kind, discovererName);
    }

    @Override
    public String addSpot(String spotName, String... exhibits) {
        Spot spot = new SpotImpl(spotName);

        for (String exhibit : exhibits) {
            spot.getExhibits().add(exhibit);
        }

        this.spotRepository.add(spot);

        return String.format(ConstantMessages.SPOT_ADDED, spotName);
    }

    @Override
    public String excludeDiscoverer(String discovererName) {
        Discoverer discoverer = this.discovererRepository.byName(discovererName);

        if (discoverer == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.DISCOVERER_DOES_NOT_EXIST, discovererName));
        }

        this.discovererRepository.remove(discoverer);

        return String.format(ConstantMessages.DISCOVERER_EXCLUDE, discovererName);
    }

    @Override
    public String inspectSpot(String spotName) {
        Spot spot = this.spotRepository.byName(spotName);

        Collection<Discoverer> collection = this.discovererRepository.getCollection();
        List<Discoverer> goingToMission = new ArrayList<>();

        for (Discoverer discoverer : collection) {
            if (discoverer.getEnergy() > 45) {
                goingToMission.add(discoverer);
            }
        }

        if (goingToMission.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.SPOT_DISCOVERERS_DOES_NOT_EXISTS);
        }

        inspectionCount++;
        this.operation.startOperation(spot, goingToMission);

        long excluded = goingToMission.stream().filter(d -> d.getEnergy() == 0).count();

        return String.format(ConstantMessages.INSPECT_SPOT, spotName, excluded);

    }

    @Override
    public String getStatistics() {
        String discoverers = this.discovererRepository.getCollection()
                .stream()
                .map(Discoverer::toString)
                .collect(Collectors.joining("\n"));

        return String.format(ConstantMessages.FINAL_SPOT_INSPECT, this.inspectionCount) + "\n" +
                String.format(ConstantMessages.FINAL_DISCOVERER_INFO) + "\n" +
                discoverers;
    }
}
