# Preface

This directory contains examples and explanations related to atomic operations in concurrent programming using Java.
Atomic operations are crucial for ensuring thread safety and consistency when multiple threads access shared resources.

## Problem

- What happens when Bob and Alice try to withdraw money from the same bank account at the same time?

## Solution

To solve this problem, we can use atomic operations provided by the `java.util.concurrent.atomic` package.
Atomic classes like `AtomicInteger`, `AtomicLong`, and `AtomicReference` provide methods that perform atomic operations
on single variables without the need for explicit synchronization.