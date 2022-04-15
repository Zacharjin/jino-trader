
export interface StockPrice {
    value: number;
}

export interface StockValue {
    icon: string;
    position: number;
    name: string;
    current: StockPrice
    last: StockPrice


}