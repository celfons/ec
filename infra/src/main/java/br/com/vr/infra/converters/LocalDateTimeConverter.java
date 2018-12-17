package br.com.vr.infra.converters;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import org.joda.time.DateTime;

public class LocalDateTimeConverter implements DynamoDBTypeConverter<String, DateTime> {

    @Override
    public String convert( final DateTime time ) {

        return time.toString();
    }

    @Override
    public DateTime unconvert( final String stringValue ) {

        return DateTime.parse(stringValue);
    }
}