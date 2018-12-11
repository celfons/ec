package br.com.vr.domains.events;

import br.com.vr.domains.shared.Event;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import lombok.NoArgsConstructor;

@DynamoDBDocument
@NoArgsConstructor
public class PurchaseCardEvents implements Event {

}
