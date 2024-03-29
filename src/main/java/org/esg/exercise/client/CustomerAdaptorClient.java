package org.esg.exercise.client;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.esg.exercise.exception.CustomerAdaptorUnavailableException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RequiredArgsConstructor
@Component
public class CustomerAdaptorClient {

    private static final String CUSTOMERS_CONTACT_SAVE_URI = "/customers/contact/save";
    private final RestTemplate customerAdaptorRestTemplate;

    public void sendCustomerContactDetail(final String payload) {
        try {
            customerAdaptorRestTemplate
                    .postForEntity(CUSTOMERS_CONTACT_SAVE_URI, payload, Void.class);
        } catch (final RestClientException e) {
            throw new CustomerAdaptorUnavailableException(e.getMessage(), "Getting Customer");
        }
    }
}
