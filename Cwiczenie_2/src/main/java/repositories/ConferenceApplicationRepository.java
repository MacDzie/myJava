package repositories;

import domain.ConferenceApplication;

public interface ConferenceApplicationRepository {

    ConferenceApplication getApplicationByEmailAddress(String email);
    void add(ConferenceApplication application);
    int count();
}
