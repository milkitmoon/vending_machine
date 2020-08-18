# 1. 개요
- CUI 형태로 간단한 자동판매기 어플리케이션을 개발하였습니다.
- 자동판매기는 사용자가 동전 혹은 지폐를 임의의 액수만큼 넣고 제품을 선택하면 사용자가 선택한 제품을 사용자에게 반환합니다.
- 자동판매기는 동전 투입기와 지폐 투입기 그리고 디스플레이가 있습니다
- 자동판매기의 투입기, 디스플레이 기기는 각각 언제든 다른 제조사의 제품으로 교체 될 수 있습니다.
  ex1) 자동판매기에 B사 동전 투입기, C사 지폐 투입기, D사 디스플레이
  ex2) 자동판매기에 H사 동전 투입기, L사 지폐 투입기, I사 디스플레이
- 자동판매기의 동전/지폐 투입기들은 제조사마다 인식하는 통화가 다를 수 있으며, 각 투입기들은 모두 1개 이상의 통화를 인식 가능합니다.
- 디스플레이 제조사마다 지원하는 언어 및 안내 문구가 다를 수 있습니다.
- 자동판매기를 통해 판매되는 제품은 여러가지 종류들이 있습니다.
- 금액을 투입기를 통해 투입하고 사용자가 제품을 선택하면 선택된 해당 제품이 사용자에게 반환됩니다.
- 제품이 반환된 후 사용자는 추가로 제품을 구매하거나 거스름돈을 반환할 수 있습니다.


# 2. 기술명세
- 언어 : Java 1.8
- IDE : STS 4
- 프레임워크 & lib : 사용하지 않음
- 기타 : strategy, template method, delegation, builder 패턴 등을 사용하여 구현하였습니다.


# 3. 설정

> 동전/지폐/디스플레이 설정
- 프로젝트 홈의 'vending.cnf' 파일을 통해 설정을 조절할 수 있습니다.
<img src="https://user-images.githubusercontent.com/61044774/90479845-47773880-e16a-11ea-9e17-24299e49b846.png" width="80%"></img>


- 동전과 지폐는 A/B/C 타입 선택
각 타입을 선택 했을 시에 투입할 수 있는 통화가 달라 집니다. (ex. A타입 : 100원, 500원 가능, B타입 : 10월, 100원, 500원 가능)
- 디스플레이는 A/B 타입 선택
타입별로 화면에 표시되는 언어와 문구가 달라질 수 있습니다.


# 4. 실행

> IDE를 통한 실행 
- com.milkit.app.vending.main 패티지의 VendingMain.java 소스에서 main 메소드를 선택하여 실행하실 수 있습니다.

<img src="https://user-images.githubusercontent.com/61044774/90481365-98882c00-e16c-11ea-99d3-e6f9d77e73dd.png" width="100%"></img>

---

> Console을 통한 실행 
- console을 실행 후 project 홈디렉토리에서 'run.bat' 파일을 실행하실 수 있습니다.
<img src="https://user-images.githubusercontent.com/61044774/90480166-d6845080-e16a-11ea-9a09-dc931b6c631f.png" width="100%"></img>


# 5. 사용
> 기본화면
<img src="https://user-images.githubusercontent.com/61044774/90480365-18ad9200-e16b-11ea-961a-6d932f329ffa.png" width="100%"></img> 

## 5.1 동전/지폐 투입기 정보
- 동전/지폐 투입가능 통화목록을 표시하며 해당 단위로만 금액이 투입 가능합니다.

## 5.2 판매상품 목록 정보
- 자동판매기에서 판매되는 상품정보를 표시합니다.
- 현재 투입한 금액에 대비하여 '구입가능'과 '잔액부족' 으로 상품 구매가능 여부를 표시합니다.

## 5.3 사용방법 설명
- 투입가능 통화단위를 표시합니다. (표시 정보는 통전 투입기 설정에 따라 달라집니다.) 
- 판매상품코드 입력 정보를 표시합니다. (표시 정보는 상품코드에 따라 달라집니다.)
- 'y' 를 입력하면 구매가 완료됩니다. (구매상품 목록 및 거스름돈 정보가 표시됩니다.)
- 'c' 를 입력하면 구매가 취소됩니다. (구매상품과 투입금액이 초기화 됩니다.)
- 'x' 를 입력하면 자동판매기 프로그램이 종료됩니다.

## 5.4 구매 정보
- 구매상품 정보가 표시됩니다. ([커피 2개 구매, 승차권 1매] 구매 시 -> [커피 X 2, 승차권 X 1] 과 같이 표기)
- 현재 남은 금액이 표시 됩니다. (남은금액 = 투입금액 - 상품구입금액)

