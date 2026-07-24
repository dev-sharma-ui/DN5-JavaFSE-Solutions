# Git Hands-on Lab 4

## Objective

Learn how to resolve merge conflicts in Git.

---

## Create a New Branch

```bash
git checkout -b feature-branch
```

---

## Modify a File

```text
Edit any existing file.
```

---

## Stage Changes

```bash
git add .
```

---

## Commit Changes

```bash
git commit -m "Updated file in feature branch"
```

---

## Switch to Main Branch

```bash
git checkout main
```

---

## Modify the Same File

```text
Edit the same file with different content.
```

---

## Commit Changes

```bash
git add .
git commit -m "Updated file in main branch"
```

---

## Merge Feature Branch

```bash
git merge feature-branch
```

If both branches modified the same lines, Git reports a merge conflict.

---

## Resolve Merge Conflict

Open the conflicted file, remove the conflict markers, and keep the desired content.

---

## Stage Resolved File

```bash
git add .
```

---

## Complete Merge

```bash
git commit -m "Resolved merge conflict"
```

---

## Verify Commit History

```bash
git log --oneline --graph
```