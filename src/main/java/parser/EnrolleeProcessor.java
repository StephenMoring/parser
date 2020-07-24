package parser;

import java.util.ArrayList;
import java.util.List;

import filters.AscendingNameFilter;
import filters.InsuranceCompanyFilter;
import filters.VersionFilter;
import models.Enrollee;

public class EnrolleeProcessor {
	
    public static List<List<Enrollee>> process(List<Enrollee> enrollees){
    	List<List<Enrollee>> filesToWrite = new ArrayList<>();
    	if(!enrollees.isEmpty()) {
    		Pipeline<List<Enrollee>, List<List<Enrollee>>> enrolleePipeline = new Pipeline<>(new InsuranceCompanyFilter())
    				.addFilter(new VersionFilter())
    				.addFilter(new AscendingNameFilter());
    		filesToWrite = enrolleePipeline.execute(enrollees);
    	}
		return filesToWrite;
    }
    
}
