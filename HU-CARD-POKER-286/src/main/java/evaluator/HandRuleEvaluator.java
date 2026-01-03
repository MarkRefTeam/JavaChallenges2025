package evaluator;

import java.util.Collection;

public class HandRuleEvaluator {

    boolean isPoker(Collection<Long> valueCounts) {
        return valueCounts.stream().anyMatch(c -> c == 4L);
    }

    boolean isFlush(Collection<Long> colourCounts) {
        return colourCounts.stream().anyMatch(c -> c == 7L);
    }

    boolean isAlmostFlush(Collection<Long> colourCounts) {
        return colourCounts.stream().anyMatch(c -> c >= 4L && c <= 6L);
    }
}
