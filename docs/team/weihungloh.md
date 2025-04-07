---
  layout: default.md
  title: "John Doe's Project Portfolio Page"
---

### Project: CareBook

AddressBook - Level 3 is a desktop address book application used for teaching Software Engineering principles. The user interacts with it using a CLI, and it has a GUI created with JavaFX. It is written in Java, and has about 10 kLoC.

Given below are my contributions to the project.

* **New Feature**: Added the ability to undo/redo previous commands.
  * What it does: allows the user to undo all previous commands one at a time. Preceding undo commands can be reversed by using the redo command.
  * Justification: This feature improves the product significantly because a user can make mistakes in commands and the app should provide a convenient way to rectify them.
  * Highlights: This enhancement affects existing commands and commands to be added in future. It required an in-depth analysis of design alternatives. The implementation too was challenging as it required changes to existing commands.
  * Credits: *{mention here if you reused any code/ideas from elsewhere or if a third-party library is heavily used in the feature so that a reader can make a more accurate judgement of how much effort went into the feature}*

* **New Feature**: Added the ability to export student records into a .csv file
  * What it does: This feature allows users to store student name, parent name, parent phone number, parent email, address, student ID into a separate .csv with timestamp captured.
  * Justification: This feature improves the product significantly because daycare teachers can copy paste a list of parent's email and send a mass announcement to the parents

* **Edited Features**: Added the ability to find students based on student ID
  * What it does: This feature allows daycare teachers to find student based on student ID. A find window is opened that reveals all information associated to that student. Users are not able to execute another command withotu first closing that find window.
  * Justification: Our current list feature only shows users a list of students with their names and student ID. The rest of information is not shown to prevent cluttering. Thus, find window helps users to retrieve important information.

* **Edited Features**: Added the ability to delete students based on student ID
  * What it does: This feature allows daycare teachers to delete a student based on his student ID. Since student ID is unique, that is the only way to delete a student from record.
  * Justification: Our student id should be unique.

* **Code contributed**: [RepoSense link]()

* **Project management**:
  * Managed releases `v1.3` - `v1.5rc` (3 releases) on GitHub

* **Enhancements to existing features**:
  * Updated the GUI color scheme (Pull requests [\#33](), [\#34]())
  * Wrote additional tests for existing features to increase coverage from 88% to 92% (Pull requests [\#36](), [\#38]())

* **Documentation**:
  * User Guide:
    * Added documentation for the features `delete` and `find` [\#72]()
    * Did cosmetic tweaks to existing documentation of features `clear`, `exit`: [\#74]()
  * Developer Guide:
    * Added implementation details of the `delete` feature.

* **Community**:
  * PRs reviewed (with non-trivial review comments): [\#12](), [\#32](), [\#19](), [\#42]()
  * Contributed to forum discussions (examples: [1](), [2](), [3](), [4]())
  * Reported bugs and suggestions for other teams in the class (examples: [1](), [2](), [3]())
  * Some parts of the history feature I added was adopted by several other class mates ([1](), [2]())

* **Tools**:
  * Integrated a third party library (Natty) to the project ([\#42]())
  * Integrated a new Github plugin (CircleCI) to the team repo
