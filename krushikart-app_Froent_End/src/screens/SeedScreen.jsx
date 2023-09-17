import React, { useState, useEffect } from 'react'
import { Row, Col } from 'react-bootstrap'
import ProductScreen from './ProductScreen'
import base_url from '../api/bootapi'
import httpClient from '../http-common'
import Layout from '../components/Layout'

const SeedScreen = () => {
  const [Products, setProducts] = useState([])

  useEffect(() => {
    const fetchAllProducts = async () => {
      const { data } = await httpClient.get(`${base_url}/api/prod/Seeds`)
      setProducts(data)
    }
    fetchAllProducts()
  }, [])

  return (
    <div>
      <h1>All Seeds Products</h1>
      <Row>
        {Products.map((seed) => (
          <Col key={seed.id} md={3}>
            <ProductScreen product={seed} />
          </Col>
        ))}
      </Row>
    </div>
  )
}

export default SeedScreen
