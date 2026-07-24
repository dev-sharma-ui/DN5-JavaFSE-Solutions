# Git Hands-on Lab 1

## Objective

Learn the basic Git commands used to configure Git and initialize a repository.

---

## Check Git Version

```bash
git --version
```

---

## Configure Username

```bash
git config --global user.name "Your Name"
```

---

## Configure Email

```bash
git config --global user.email "your-email@example.com"
```

---

## Verify Configuration

```bash
git config --list
```

---

## Set VS Code as Default Editor

```bash
git config --global core.editor "code --wait"
```

---

## Initialize Repository

```bash
git init
```

---

## Check Repository Status

```bash
git status
```

---

## Stage Files

```bash
git add .
```

---

## Commit Changes

```bash
git commit -m "Initial Commit"
```

---

## Connect Remote Repository

```bash
git remote add origin <repository-url>
```

---

## Push Changes

```bash
git push -u origin main
```

---

## Pull Latest Changes

```bash
git pull origin main
```