package filters;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import models.Enrollee;

public class InsuranceCompanyFilter implements Filter<List<Enrollee>, List<List<Enrollee>>>{

	@Override
	public List<List<Enrollee>> process(List<Enrollee> input) {
		List<List<Enrollee>> filesToWrite = new ArrayList<>();
    	Set<String> insuranceCompanies = new HashSet<>();
		for(Enrollee en : input) {
			insuranceCompanies.add(en.getInsurance());
    	}
		for(String insurance : insuranceCompanies) {
			List<Enrollee> users = input.stream()
					.filter(p -> p.getInsurance().equals(insurance))
					.collect(Collectors.toList());
			filesToWrite.add(users);
		}
		return filesToWrite;
	}

}
