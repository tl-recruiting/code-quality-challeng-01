package io.tradeledger.challenge;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ConfigurationValidator {

    public void validate(List<Configuration> configurations) {

        // validating uniqueness of ids
        Set<String> uniqueIds = configurations.stream()
                .map(Configuration::getId)
                .collect(Collectors.toSet());

        if (uniqueIds.size() < configurations.size()) {
            throw new RuntimeException("there are duplicate id");
        }

        // validating no shared url
        // your code here ...

    }
}
