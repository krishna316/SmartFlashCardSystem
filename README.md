# Smart Flashcard System

A Spring Boot backend that allows students to create flashcards.  
The subject of each flashcard is inferred automatically (rule-based or ML-based).  

##  Features
- Add flashcards with subject detection
- Fetch mixed flashcards by student
- Rule-based classifier (Physics, Biology, Math, History, General)
- ML-based classifier option (Hugging Face via DJL)

## 🔧 Installation
```bash
git clone https://github.com/krishna316/SmartFlashCardSystem.git
cd SmartFlashCardSystem
mvn clean install
