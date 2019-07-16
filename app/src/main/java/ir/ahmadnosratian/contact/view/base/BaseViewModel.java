package ir.ahmadnosratian.contact.view.base;


import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableBoolean;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import ir.ahmadnosratian.contact.data.DataManager;
import ir.ahmadnosratian.contact.utils.rx.SchedulerProvider;

public abstract class BaseViewModel<N> extends ViewModel {

    private DataManager mDataManager;

    ObservableBoolean mIsLoading = new ObservableBoolean();

    private CompositeDisposable mCompositeDisposable;

    private SchedulerProvider mSchedulerProvider;

    private WeakReference<N> mNavigator;


    public BaseViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        this.mCompositeDisposable = new CompositeDisposable();
        this.mDataManager = dataManager;
        this.mSchedulerProvider = schedulerProvider;
    }

    @Override
    protected void onCleared() {
        mCompositeDisposable.clear();
        super.onCleared();
    }

    public CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }

    public DataManager getDataManager() {
        return mDataManager;
    }

    public SchedulerProvider getSchedulerProvider() {
        return mSchedulerProvider;
    }

    public ObservableBoolean getmIsLoading() {
        return mIsLoading;
    }

    public void setIsLoading(boolean isLoading) {
        mIsLoading.set(isLoading);
    }

    public void setNavigator(N navigator) {
        this.mNavigator = new WeakReference<>(navigator);
    }

    public N getNavigator() {
        return mNavigator.get();
    }


}
