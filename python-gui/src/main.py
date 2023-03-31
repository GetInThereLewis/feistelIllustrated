from PyQt6.QtWidgets import QApplication, QMainWindow, QVBoxLayout, QPushButton, QLabel, QWidget, QLineEdit
from PyQt6.QtCore import QFile, QIODevice, Qt
import os
app = QApplication([])  # Create a new QApplication instance


with open("python-gui/src/style/style.css", "r") as file:
    app.setStyleSheet(file.read())


window = QMainWindow()  # Create a new QMainWindow instance

# Create and add widgets to the layout

btnStart = QPushButton("Start")
btnStart.setObjectName("btnStart")
btnStart.resize(120, 80)
layout = QVBoxLayout()
layout.addWidget(btnStart)
lineEdit = QLineEdit()
btnStart.setFixedSize(120, 80)
layout.setAlignment(Qt.AlignmentFlag.AlignCenter)
# lineEdit.setStyleSheet(
#    "background-color: lightgreen; border: none; border-radius: 12px; width: 200px; padding: 10px; margin: 0 auto;")


# Set the layout as the central widget of the main window
central_widget = QWidget()
central_widget.setLayout(layout)
window.setCentralWidget(central_widget)
window.resize(800, 800)

window.show()  # Show the main window

app.exec()  # Enter the event loop
