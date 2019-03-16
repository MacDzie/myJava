package repositories;

import domain.ConferenceApplication;

import java.util.ArrayList;
import java.util.List;

public class DummyConferenceApplicationRepository implements ConferenceApplicationRepository{

    private static List<ConferenceApplication> db
            = new ArrayList<ConferenceApplication>();

    public ConferenceApplication getApplicationByEmailAddress(String email) {
        for(ConferenceApplication application: db) {
            if(application.getEmail().equalsIgnoreCase(email))
                return application;
        }
        return null;
    }

    public void add(ConferenceApplication application) {
        db.add(application);
    }

    public int count() {
        return db.size();
    }
}
