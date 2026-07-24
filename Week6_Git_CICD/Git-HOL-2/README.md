# Git Hands-on Lab 2

## Objective

Learn how to work with branches in Git.

---

## Create a New Branch

```bash
git branch feature-branch
```

---

## View All Branches

```bash
git branch
```

---

## Switch to Branch

```bash
git checkout feature-branch
```

or

```bash
git switch feature-branch
```

---

## Create and Switch in One Command

```bash
git checkout -b feature-branch
```

or

```bash
git switch -c feature-branch
```

---

## Make Changes

```bash
git add .
git commit -m "Added new feature"
```

---

## Merge Branch

```bash
git checkout main
git merge feature-branch
```

---

## Delete Local Branch

```bash
git branch -d feature-branch
```

---

## Delete Remote Branch

```bash
git push origin --delete feature-branch
```

---

## View Commit History

```bash
git log --oneline --graph --all
```