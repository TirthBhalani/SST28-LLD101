LLD Refactoring: Assignment Evaluation Pipeline (DIP)
1. Problem Statement
The system automates the grading of student submissions by running them through a sequence of checks: plagiarism detection, code grading, and report generation.

2. Initial Design Architecture
The Pipeline: The EvaluationPipeline acted as the "orchestrator."

The Linkage: Inside its evaluate() method, it explicitly created instances of PlagiarismChecker, CodeGrader, and ReportWriter using the new keyword.

The Coupling: The high-level logic (how to evaluate) was tightly coupled to specific low-level implementations (how a specific grader works).

3. Issues with the Initial Design
DIP Violation: High-level modules depended on low-level concretes rather than abstractions.

Hard to Test: You could not test the pipeline logic without also running the actual (potentially slow or complex) grading logic.

Rigid Configuration: If you wanted to swap a ReportWriter with an EmailWriter, you had to modify the core pipeline code.

Mixed Responsibilities: The pipeline was responsible for both instantiating objects and executing business logic.

Open-Closed Violation: Adding a new grading strategy required breaking open the pipeline's internal methods.

4. The Solution: Dependency Inversion
We refactored the design to ensure the pipeline depends on interfaces, not concretes:

Abstraction Layer: We introduced IPlagiarismChecker, ICodeGrader, and IReportWriter.

Inversion of Control: The pipeline no longer creates its own dependencies. Instead, they are "injected" via the constructor.

Decoupling: The pipeline now only cares that an object can check plagiarism; it doesn't care which specific class is doing it.

Testability: We can now easily pass "mock" implementations into the pipeline for unit testing without needing the real grading logic.