# Git Hands-on Lab 3

## Objective

Learn how to clone repositories and work with remote repositories.

---

## Clone Repository

```bash
git clone <repository-url>
```

Example:

```bash
git clone https://github.com/username/project.git
```

---

## Check Remote Repository

```bash
git remote -v
```

---

## Add Remote Repository

```bash
git remote add origin <repository-url>
```

---

## Rename Remote

```bash
git remote rename origin upstream
```

---

## Remove Remote

```bash
git remote remove upstream
```

---

## Fetch Latest Changes

```bash
git fetch origin
```

---

## Pull Latest Changes

```bash
git pull origin main
```

---

## Push Changes

```bash
git push origin main
```

---

## Push New Branch

```bash
git push -u origin feature-branch
```

---

## Check Branch Status

```bash
git branch -a
```