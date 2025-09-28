# SADP_codes
SADP_codes

IMP
# (pip install requests) to execute this in terminal
import requests

url = "https://raw.githubusercontent.com/PhapaleSai/sadp/main/Slip1.txt"

response = requests.get(url)

if response.status_code == 200:
    print(response.text)
else:
    print("error")
