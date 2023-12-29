export interface NewOrderDto { 
    total?: number;
    paymentMethod?: string;
    productIdList?: Array<Number>;
    email?: string;
}