import React, { useState, useEffect } from 'react'
import httpClient from '../http-common'
import base_url from '../api/bootapi'
import Product from '../products'
import {
  Row,
  Col,
  ListGroup,
  Button,
  Image,
  ListGroupItem,
} from 'react-bootstrap'
import { useParams } from 'react-router-dom'
import { Link } from 'react-router-dom'

const ProductDetails = ({ match }) => {
  // const product = Product.find((p) => p.id === match.params.id)

  const { id } = useParams()

  const [product, setProduct] = useState([])

  useEffect(() => {
    const fetchAllProduct = async () => {
      const { data } = await httpClient.get(`${base_url}/api/prod/prod/${id}`)
      setProduct(data)
    }
    fetchAllProduct()
  }, [match])

  return (
    <div>
      <h1>Product Details </h1>
      <hr></hr>
      <Link to="/" className="btn btn-light">
        <i className="fas fa-arrow-left    "></i>
        &nbsp; GO BACK
      </Link>
      <Row>
        <Col md={6}>
          <Image src={product.imageUrl} alt={product.prodName} fluid />
        </Col>
        <Col md={3}>
          <ListGroup variant="flush">
            <ListGroupItem>
              <h3>{product.prodName}</h3>
            </ListGroupItem>
            <ListGroupItem> Price :Rs. {product.unitPrice} </ListGroupItem>
            <ListGroupItem> {product.prodDesc} </ListGroupItem>
          </ListGroup>
        </Col>

        <Col md={3}>
          <ListGroupItem>
            <Row>
              <Col>Status : </Col>
              <Col>
                {product.prodQuantity > 0 ? 'In Stock ' : 'Out of stock'}
              </Col>
            </Row>
          </ListGroupItem>
          <hr></hr>
          <ListGroupItem>
            <Row>
              <Col>Seller Contact No : </Col>
              <Col>{' 012-3456789'}</Col>
            </Row>
          </ListGroupItem>
          <hr></hr>
          <ListGroupItem>
            <Button
              className="btn-block"
              type="button"
              // onClick={addToCartHandler}
            >
              Add to cart
            </Button>
          </ListGroupItem>
        </Col>
      </Row>
    </div>
  )
}

export default ProductDetails
