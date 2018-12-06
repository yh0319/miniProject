# 알라딘, 위키북스
# 1인 1작품, 2인 1팀


import requests
import lxml.html
import re
import time


def main():
    session = requests.Session()
    response = session.get("http://wikibook.co.kr/")
    urls = scrape_list_page(response)
    
    for url in urls:
        time.sleep(1)
        response = session.get(url)
        bookInfo = scrape_detail_page(response)
        print(bookInfo)
        

def scrape_list_page(response):
    root = lxml.html.fromstring(response.text)
    root.make_links_absolute(response.url)
    for a in root.cssselect('.book-in-front a'):
        url = a.get('href')
        yield url


def scrape_detail_page(response):
    root = lxml.html.fromstring(response.text)
    bookInfo = {
        'url' : response.url,
        'title' : root.cssselect(".main-title")[0].text_content(),
        'price' :  regExp(root.cssselect(".col-md-9 > ul > li:nth-child(8)")[0].text_content()),
        'content' : [normalize_space(p.text_content()) 
                                    for p in root.cssselect("#toc ul")]
    }
    return bookInfo


def normalize_space(s):
    return re.sub(r'\s+', ' ', s).strip()


def regExp(s):
    pattern = re.compile(r'(\d+[,]\d+)')
    price = pattern.search(s).group(1)
    return price


if __name__ == "__main__":
    main()