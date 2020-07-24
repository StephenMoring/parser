package filters;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import models.Enrollee;

public class VersionFilter implements Filter<List<List<Enrollee>>, List<List<Enrollee>>>{

	@Override
	public List<List<Enrollee>> process(List<List<Enrollee>> input) {
		List<List<Enrollee>> filesToWrite = new ArrayList<>();
		for(List<Enrollee> enrolleeList : input) {
			Set<String> enrolleIds = new HashSet<>();
			for(Enrollee en : enrolleeList) {
				enrolleIds.add(en.getUserId());
			}
			List<Enrollee> maxVersionEnrollees = new ArrayList<>();
			for(String id : enrolleIds) {
				Optional<Enrollee> maxVersionEnrollee = enrolleeList.stream()
						.filter(p -> p.getUserId().equals(id))
						.max(Comparator.comparing(Enrollee::getVersion));
				if(maxVersionEnrollee.isPresent()) {
					maxVersionEnrollees.add(maxVersionEnrollee.get());
				}
			}
			filesToWrite.add(maxVersionEnrollees);
    	}
		return filesToWrite;
	}
	
}
