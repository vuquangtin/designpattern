package javacodegeeks.com.gkatzioura.design.behavioural.iterator1;

import java.util.ArrayList;
import java.util.List;

public class GitHubIterator implements Iterator<GitHubJob> {

    private List<GitHubJob> currentJobsPage = new ArrayList<>();
    private int page = 0;

    private final GitHubJobsRepository gitHubJobsRepository;

    public GitHubIterator(GitHubJobsRepository gitHubJobsRepository) {
        this.gitHubJobsRepository = gitHubJobsRepository;
    }

    @Override
    public boolean hasNext() {
        fetchPageIfNeeded();
        return currentJobsPage.size()>0;
    }

    @Override
    public GitHubJob next() {
        fetchPageIfNeeded();

        if(currentJobsPage.size()==0) {
            return null;
        }

        return currentJobsPage.remove(0);
    }

    private void fetchPageIfNeeded() {
        if(page == -1) {
            return;
        }

        if(currentJobsPage==null||currentJobsPage.size()==0) {
            try {
                currentJobsPage = gitHubJobsRepository.fetch(page);
                if(currentJobsPage.size()==0) {
                    page = -1;
                } else {
                    page++;
                }
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }
    }
}
