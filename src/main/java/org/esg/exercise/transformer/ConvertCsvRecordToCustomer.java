package org.esg.exercise.transformer;

import org.esg.exercise.dto.CustomerDto;
import org.springframework.stereotype.Component;

@Component
public class ConvertCsvRecordToCustomer {
    private String[] csvRecord;

    public CustomerDto transform(final String csvRecordString) {
        csvRecord = csvRecordString.split(",");
        return CustomerDto.builder()
                .customerRef(dataTypeSetter(0))
                .customerName(dataTypeSetter(1))
                .addressLineOne(dataTypeSetter(2))
                .addressLineTwo(dataTypeSetter(3))
                .town(dataTypeSetter(4))
                .county(dataTypeSetter(5))
                .country(dataTypeSetter(6))
                .postcode(dataTypeSetter(7))
                .build();
    }

    private String dataTypeSetter(final int index) {
        return csvRecord[index].replace("\"", "");
    }
}
