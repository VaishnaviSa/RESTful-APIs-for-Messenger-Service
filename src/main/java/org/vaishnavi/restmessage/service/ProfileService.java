package org.vaishnavi.restmessage.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.vaishnavi.restmessage.database.DataBaseClass;
import org.vaishnavi.restmessage.model.Profile;


public class ProfileService {

	private Map<String, Profile> profiles = DataBaseClass.getProfiles();
	
	public ProfileService() {
		profiles.put("vaishnavi", new Profile(1L, "vaishnavi", "abc", "abc"));
	}
	
	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(profiles.values()); 
	}
	
	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile) {
		if (profile.getProfileName().isEmpty()) {
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeProfile(String profileName) {
		return profiles.remove(profileName);
	}
	
	
}
