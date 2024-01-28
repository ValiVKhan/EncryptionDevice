# File Encryption and Decryption System
This repository contains a simple Java-based command-line application for encrypting and decrypting files using a custom encryption algorithm. The system provides the following functionalities:

Encrypt a file
Decode an encrypted file
Quit the system
### Prerequisites
JDK 8 or later
### Building and Running the Application
Clone the repository:
Download
Copy code
git clone https://github.com/your-username/file-encryption-decryption.git
Navigate to the project directory:
Download
Copy code
cd file-encryption-decryption
Compile the Java files:
Download
Copy code
javac Active.java Decode.java Encrypt.java Key.java
Run the application:
Download
Copy code
java Active
### Usage
Upon running the application, you will be prompted to select one of the following options:
1. Ecrypt File
2. Decode encrypted file
3. Quit system
4. Enter the corresponding number to perform the desired action.

### Encrypting a File
To encrypt a file, follow these steps:

Select option 1 (Ecrypt File) from the main menu.
Enter the file path for the file you want to encrypt.
Enter the level of encryption (an integer value).
The encrypted file will be saved with the same name as the original file, but with the suffix _encrypted.txt appended to it.

### Decoding an Encrypted File
To decode an encrypted file, follow these steps:

Select option 2 (Decode encrypted file) from the main menu.
Enter the path for the encrypted file you want to decode.
The decoded file will be saved with the same name as the original encrypted file, but with the suffix _decode.txt appended to it.

### Custom Encryption Algorithm
The custom encryption algorithm used in this application involves creating a key based on the level of encryption provided by the user. The key is then used to map each character in the input file to a new character based on the key values. The decoding process reverses this mapping to restore the original content of the file.
