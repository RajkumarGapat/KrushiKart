import React from 'react'
import { Card } from 'react-bootstrap'
import { Link } from 'react-router-dom'
import base_url from '../api/bootapi'
import httpClient from '../http-common'
import ProductDetails from './ProductDetails'
import { useCart } from '../context/Cart'
import { toast, Toaster } from 'react-hot-toast'

const ProductScreen = ({ product }) => {
  const [cart, setCart] = useCart()
  return (
    <>
      <Card className="my-3 p-3 rounded">
        <Link to={`/api/prod/prod/${product.id}`}>
          <Card.Img src={product.imageUrl} variant="top" />
        </Link>
      </Card>
      <Card.Body className="text-center">
        <Card.Text as="div">
          <button
            className="btn btn-success col-md-12"
            onClick={
              () => {
                setCart([...cart, product])
                localStorage.setItem('cart', JSON.stringify([...cart, product]))
              }
              // toast.success('Items addded to cart'))
            }
          >
            Add To Cart
          </button>
        </Card.Text>
        <Link to={`/api/prod/prod/${product.id}`}>
          <Card.Title as="div">
            <strong>{product.prodName}</strong>
          </Card.Title>
        </Link>
        <Card.Text as="div">Rs. {product.unitPrice}</Card.Text>
      </Card.Body>
    </>
  )
}

export default ProductScreen
