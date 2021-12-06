package io.tradeledger.challenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ConfigurationValidatorTest {

    private ConfigurationValidator configurationValidator;

    @BeforeEach
    void setUp() {
        configurationValidator = new ConfigurationValidator();
    }

    @Test
    void validate_duplicateId() {
        var configurations = List.of(
                new Configuration("1", List.of("https://portal1.domain1.com", "https://admin1.domain1.com")),
                new Configuration("1", List.of("https://portal2.domain1.com", "https://admin2.domain1.com"))
        );

        var expectedException = assertThrows(RuntimeException.class, () -> configurationValidator.validate(configurations));
        assertThat(expectedException.getMessage(), equalTo("there are duplicate id"));
    }

    @Test
    void validate_sharedUrl() {
        var configurations = List.of(
                new Configuration("1", List.of("https://portal1.domain1.com", "https://admin1.domain1.com")),
                new Configuration("2", List.of("https://portal2.domain1.com", "https://admin1.domain1.com"))
        );

        var expectedException = assertThrows(RuntimeException.class, () -> configurationValidator.validate(configurations));
        assertThat(expectedException.getMessage(), equalTo("configurations [1, 2] share the 'https://admin1.domain1.com' url"));
    }
}