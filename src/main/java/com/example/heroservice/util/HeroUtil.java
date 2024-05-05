package com.example.heroservice.util;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.example.heroservice.model.Hero;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

public class HeroUtil {

	public static List<Hero> getHerosList() {
		try {

			Path filePath = Path.of("D:\\Users\\gnavamanirajan\\Ganesaprabu\\Development\\Integration_Issue\\heroservice\\src\\main\\resources\\herosData.json");
			String content = Files.readString(filePath);
			
			ObjectMapper objectMapper = new ObjectMapper();
			CollectionType listType = objectMapper.getTypeFactory().constructCollectionType(ArrayList.class,
					Hero.class);
			List<Hero> heroList = objectMapper.readValue(content, listType);
			return heroList;
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static String getJsonString() {
		return "[\r\n"
				+ "	{\r\n"
				+ "		\"id\": 12,\r\n"
				+ "		\"name\": \"Dr. Nice\"\r\n"
				+ "	},\r\n"
				+ "	{\r\n"
				+ "		\"id\": 13,\r\n"
				+ "		\"name\": \"Bombasto456\"\r\n"
				+ "	},\r\n"
				+ "	{\r\n"
				+ "		\"id\": 14,\r\n"
				+ "		\"name\": \"Celeritas\"\r\n"
				+ "	},\r\n"
				+ "	{\r\n"
				+ "		\"id\": 15,\r\n"
				+ "		\"name\": \"Magneta\"\r\n"
				+ "	},\r\n"
				+ "	{\r\n"
				+ "		\"id\": 16,\r\n"
				+ "		\"name\": \"RubberMan\"\r\n"
				+ "	},\r\n"
				+ "	{\r\n"
				+ "		\"id\": 17,\r\n"
				+ "		\"name\": \"Dynama\"\r\n"
				+ "	},\r\n"
				+ "	{\r\n"
				+ "		\"id\": 18,\r\n"
				+ "		\"name\": \"Dr. IQ\"\r\n"
				+ "	},\r\n"
				+ "	{\r\n"
				+ "		\"id\": 19,\r\n"
				+ "		\"name\": \"Magma\"\r\n"
				+ "	},\r\n"
				+ "	{\r\n"
				+ "		\"id\": 20,\r\n"
				+ "		\"name\": \"Tornado\"\r\n"
				+ "	}\r\n"
				+ "]";
	}
}

