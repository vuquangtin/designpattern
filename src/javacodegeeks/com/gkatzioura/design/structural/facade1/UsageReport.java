package javacodegeeks.com.gkatzioura.design.structural.facade1;

import java.util.List;
import java.util.UUID;

public interface UsageReport {

    List<Usage> report(UUID uuid);

}
