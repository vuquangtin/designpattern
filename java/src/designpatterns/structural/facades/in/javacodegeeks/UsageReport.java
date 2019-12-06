package in.javacodegeeks;

import java.util.List;
import java.util.UUID;

public interface UsageReport {

    List<Usage> report(UUID uuid);

}
