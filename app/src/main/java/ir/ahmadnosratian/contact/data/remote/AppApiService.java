package ir.ahmadnosratian.contact.data.remote;

import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import io.reactivex.Single;
import ir.ahmadnosratian.contact.data.model.Contact;

@Singleton
public class AppApiService implements ApiService {

    @Inject
    public ApiService apiService;

    @Inject
    public AppApiService() {
    }

    @Override
    public Single<List<Contact>> getContacts(String source, String query) {
        return apiService.getContacts(source, query);
    }
}
