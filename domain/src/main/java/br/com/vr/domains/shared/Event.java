package br.com.vr.domains.shared;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

import java.io.Serializable;

@DynamoDBDocument
public interface Event extends Serializable {

}