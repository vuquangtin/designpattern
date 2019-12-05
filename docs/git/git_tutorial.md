# git commit

<b>The "commit" command is used to save your changes to the local repository.</b>

Note that you have to explicitly tell Git which changes you want to include in a commit before running the "git commit" command. This means that a file won't be automatically included in the next commit just because it was changed. Instead, you need to use the "git add" command to mark the desired changes for inclusion.

Also note that in Git (not like in Subversion), a commit is not automatically transferred to the remote server. Using the "git commit" command only saves a new commit object in the local Git repository. Exchanging commits has to be performed manually and explicitly (with the "git fetch", "git pull", and "git push" commands).

## Important Options
-m <message>

<b>Sets the commit's message.</b> Make sure to provide a concise description that helps your teammates (and yourself) understand what happened.
-a

<b>Includes all currently changed files in this commit.</b> Keep in mind, however, that untracked (new) files are not included.
--amend

<b>Rewrites the very last commit</b> with any currently staged changes and/or a new commit message. Git will rewrite the last commit and effectively replace it with the amended one. Note that such a rewriting of commits should only be performed on commits that have not been pushed to a remote repository, yet.

## Usage Examples
```git
git commit -a -m "Change titles and styling on homepage"
```

```git
git add forgotten-change.js
git commit --amend -m "New commit message"
```

https://git-scm.com/docs/git-commit