export * from './auth.service';
import { AuthService } from './auth.service';
export * from './order.service';
import { OrderService } from './order.service';
export * from './product.service';
import { ProductService } from './product.service';
export * from './user.service';
import { UserService } from './user.service';
export const APIS = [AuthService, OrderService, ProductService, UserService];
