package org.govithub.govac.dao.model.json;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import javax.validation.constraints.NotNull;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

@Converter
public class JsonMetadataConverter implements AttributeConverter<JsonMetadata, String> {

	    private final static ObjectMapper objectMapper = new ObjectMapper();
	    
	    private Logger logger = Logger.getLogger(JsonMetadataConverter.class);

	    @NotNull
	    public String convertToDatabaseColumn(@NotNull JsonMetadata myCustomObject) {
	        try {
	            return objectMapper.writeValueAsString(myCustomObject);
	        } catch (Exception ex) {
	            logger.error("Error while converting to jsonb", ex);
	            return null;
	        }
	    }

	    @NotNull
	    public JsonMetadata convertToEntityAttribute(@NotNull String databaseDataAsJSONString) {
	        try {
	            return objectMapper.readValue(databaseDataAsJSONString, JsonMetadata.class);
	        } catch (Exception ex) {
	        	logger.error("Error while parsing jsonb string", ex);
	            return null;
	        }
	    }
}
