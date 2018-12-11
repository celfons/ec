package br.com.vr.domains.events;

import br.com.vr.domains.shared.Event;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

@DynamoDBDocument
public interface PurchaseCardEvents extends Event {

}
