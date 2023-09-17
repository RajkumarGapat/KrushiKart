import React, { useState, useEffect } from 'react'
import { Row, Col } from 'react-bootstrap'
import ProductScreen from './ProductScreen'
import base_url from '../api/bootapi'
import httpClient from '../http-common'
import Layout from '../components/Layout'
import { useAuth } from '../context/auth'
import { useCart } from '../context/Cart'

const HomeScreen = () => {
  const [Products, setProducts] = useState([])
  const [cart] = useCart()
  const [auth, setAuth] = useAuth()

  useEffect(() => {
    const fetchAllProducts = async () => {
      const { data } = await httpClient.get(`${base_url}/api/prod`)
      setProducts(data)
    }
    fetchAllProducts()
  }, [])

  return (
    <div>
      <div className="text-center">
        <h1>All Products</h1>
        {/* <pre>{JSON.stringify(cart, null, 4)}</pre> */}
        {/* <h1>{cart[0].id}</h1> */}
      </div>
      <Row>
        {Products.map((product) => (
          <Col key={product.id} md={3}>
            <ProductScreen product={product} />
          </Col>
        ))}
      </Row>
    </div>
  )
}

export default HomeScreen
