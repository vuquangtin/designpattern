#In Terminal
##Open Terminal.
git clone https://github.com/YOUR-USERNAME/Spoon-Knife

git remote -v
> origin  https://github.com/YOUR_USERNAME/YOUR_FORK.git (fetch)
> origin  https://github.com/YOUR_USERNAME/YOUR_FORK.git (push)	

git remote add upstream https://github.com/octocat/Spoon-Knife.git

git remote -v
> origin    https://github.com/YOUR_USERNAME/YOUR_FORK.git (fetch)
> origin    https://github.com/YOUR_USERNAME/YOUR_FORK.git (push)
> upstream  https://github.com/ORIGINAL_OWNER/ORIGINAL_REPOSITORY.git (fetch)
> upstream  https://github.com/ORIGINAL_OWNER/ORIGINAL_REPOSITORY.git (push)


git pull
git commit
git push

#Setting your username in Git

##linux
Git uses a username to associate commits with an identity. The Git username is not the same as your GitHub username.

You can change the name that is associated with your Git commits using the git config command. The new name you set will be visible in any future commits you push to GitHub from the command line. If you'd like to keep your real name private, you can use any text as your Git username.

Changing the name associated with your Git commits using git config will only affect future commits and will not change the name used for past commits.
Setting your Git username for every repository on your computer

    Open Terminal.

    Set a Git username:

    $ git config --global user.name "Mona Lisa"

    Confirm that you have set the Git username correctly:

    $ git config --global user.name
    > Mona Lisa

Setting your Git username for a single repository

    Open Terminal.

    Change the current working directory to the local repository where you want to configure the name that is associated with your Git commits.

    Set a Git username:

    $ git config user.name "Mona Lisa"

    Confirm that you have set the Git username correctly:

    $ git config user.name
    > Mona Lisa

##windows
You can change the name that is associated with your Git commits using the git config command. The new name you set will be visible in any future commits you push to GitHub from the command line. If you'd like to keep your real name private, you can use any text as your Git username.

Changing the name associated with your Git commits using git config will only affect future commits and will not change the name used for past commits.
Setting your Git username for every repository on your computer

    Open Git Bash.

    Set a Git username:

    $ git config --global user.name "Mona Lisa"

    Confirm that you have set the Git username correctly:

    $ git config --global user.name
    > Mona Lisa

Setting your Git username for a single repository

    Open Git Bash.

    Change the current working directory to the local repository where you want to configure the name that is associated with your Git commits.

    Set a Git username:

    $ git config user.name "Mona Lisa"

    Confirm that you have set the Git username correctly:

    $ git config user.name
    > Mona Lisa

##mac
You can change the name that is associated with your Git commits using the git config command. The new name you set will be visible in any future commits you push to GitHub from the command line. If you'd like to keep your real name private, you can use any text as your Git username.

Changing the name associated with your Git commits using git config will only affect future commits and will not change the name used for past commits.
Setting your Git username for every repository on your computer

    Open Terminal.

    Set a Git username:

    $ git config --global user.name "Mona Lisa"

    Confirm that you have set the Git username correctly:

    $ git config --global user.name
    > Mona Lisa

Setting your Git username for a single repository

    Open Terminal.

    Change the current working directory to the local repository where you want to configure the name that is associated with your Git commits.

    Set a Git username:

    $ git config user.name "Mona Lisa"

    Confirm that you have set the Git username correctly:

    $ git config user.name
    > Mona Lisa

##All
You can change the name that is associated with your Git commits using the git config command. The new name you set will be visible in any future commits you push to GitHub from the command line. If you'd like to keep your real name private, you can use any text as your Git username.

Changing the name associated with your Git commits using git config will only affect future commits and will not change the name used for past commits.
Setting your Git username for every repository on your computer

    Open the terminal.

    Set a Git username:

    $ git config --global user.name "Mona Lisa"

    Confirm that you have set the Git username correctly:

    $ git config --global user.name
    > Mona Lisa

Setting your Git username for a single repository

    Open the terminal.

    Change the current working directory to the local repository where you want to configure the name that is associated with your Git commits.

    Set a Git username:

    $ git config user.name "Mona Lisa"

    Confirm that you have set the Git username correctly:

    $ git config user.name
    > Mona Lisa


